// taken from : https://www.geeksforgeeks.org/hamiltonian-cycle/
// with some modifications
class HamiltonianPathBacktracking
{
   int v_num = 0;
   int path[];

   boolean isSafe(int v, int graph[][], int path[], int pos)
   {
       if (graph[path[pos - 1]][v] == 0)
           return false;

       for (int i = 0; i < pos; i++)
           if (path[i] == v)
               return false;

       return true;
   }

   boolean hamPathUtil(int graph[][], int path[], int pos)
   {
       if (pos == v_num)
           return true;

       for (int v = 0; v < v_num; v++)
       {
           if (isSafe(v, graph, path, pos))
           {
               path[pos] = v;

               if (hamPathUtil(graph, path, pos + 1) == true)
                  return true;

               path[pos] = -1;
           }
       }

       return false;
   }

   int hamPath(int graph[][], int start)
   {
       path = new int[v_num];
       for (int i = 0; i < v_num; i++)
           path[i] = -1;

       path[0] = start;
       if (hamPathUtil(graph, path, 1) == false)
       {
           
           return 0;
       }

       printSolution(path);
       return 1;
   }

   boolean findHamiltonianPath(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
        if (hamPath(graph, i) == 1) {
            return true;
        }
    }
    return false;
   }

   void printSolution(int path[])
   {
       System.out.println("Solution Exists: Following" +
                         " is one Hamiltonian Path");
       for (int i = 0; i < v_num; i++)
           System.out.print(" " + path[i] + " ");
   }

   public static void main(String args[])
   {
       HamiltonianPathBacktracking hamiltonian = new HamiltonianPathBacktracking();
       int graph1[][] = {{0, 1, 0, 1, 0},
           {1, 0, 1, 1, 1},
           {0, 1, 0, 0, 1},
           {1, 1, 0, 0, 1},
           {0, 1, 1, 1, 0},
       };

       hamiltonian.hamPath(graph1, 1);

       int graph2[][] = {{0, 1, 0, 1, 0},
           {1, 0, 1, 1, 1},
           {0, 1, 0, 0, 1},
           {1, 1, 0, 0, 0},
           {0, 1, 1, 0, 0},
       };

       hamiltonian.hamPath(graph2, 1);
   }

    
}
// This code is contributed by Abhishek Shankhadhar