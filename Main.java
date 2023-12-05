import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        int[][] graph;
    
        try (BufferedReader br = new BufferedReader(new FileReader("tc_20.txt"))) {
            String line;
            line = br.readLine();
            int N = Integer.parseInt(line);
            graph = new int[N][N];

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                // jika vertex dimulai dari 0, x dan y tidak perlu dikurangi 1
                // jika vertex dimulai dari 1, x dan y dikurangi 1
                int x = Integer.parseInt(parts[0])-1;
                int y = Integer.parseInt(parts[1])-1;
                graph[x][y] = 1;
                graph[y][x] = 1;
            }
   
            System.out.println("Graph: ");
            for (int j = 0; j < N; j++) {
                System.out.print("{ ");
                for (int k = 0; k < N; k++){
                    
                    System.out.print(graph[j][k]);
                    if (k != N - 1) {
                    System.out.print(",");
                }
                }
                System.out.print(" }");
                if (j != N - 1) {
                    System.out.print(",");
                }
                System.out.println();
                
            }

            HamiltonianPathBacktracking backtracking = new HamiltonianPathBacktracking();
            
            System.gc();
            Thread.sleep(1000);

            double startTime = System.nanoTime();
            long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            backtracking.v_num = N;
            //backtracking.findHamiltonianPath(graph);
            System.out.println(HamiltonianPath.Hamiltonian_path(graph, N));

            long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long memoryUsage = memoryAfter - memoryBefore;
         
            double endTime = System.nanoTime();

            double elapsedTime = (endTime - startTime);

            System.out.println("Runtime: " + elapsedTime +  " nanoseconds");

            // total merge cost
            //
    
            System.out.println("Memory before : " + memoryBefore + " bytes");
            System.out.println("Memory after : " + memoryAfter + " bytes");
            System.out.println("Used Memory : " + memoryUsage + " bytes");

            //
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        
        }
}



            
          
