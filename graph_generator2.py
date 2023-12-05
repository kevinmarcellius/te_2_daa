import random

def generate_connected_graph(vertices, filename):
   # Create two partitions, S and T. Initially store all nodes in S.
   S, T = set(range(vertices)), set()

   # Pick a random node, and mark it as visited and the current node.
   current_node = random.sample(S, 1).pop()
   S.remove(current_node)
   T.add(current_node)

   with open(filename, 'w') as f:
       # Create a random connected graph.
       f.write(f"{vertices}\n")
       while S:
           # Randomly pick the next node from the neighbors of the current node.
           # As we are generating a connected graph, we assume a complete graph.
           neighbor_node = random.sample(S, 1).pop()
           # If the new node hasn't been visited, add the edge from current to new.
           if neighbor_node not in T:
               edge = (current_node, neighbor_node)

               # jika vertex dimulai dari 0, x dan y tidak perlu dikurangi 1
                # jika vertex dimulai dari 1, x dan y dikurangi 1
               f.write(f"{edge[0]+1} {edge[1]+1}\n")
               S.remove(neighbor_node)
               T.add(neighbor_node)
           # Set the new node as the current node.
           current_node = neighbor_node

generate_connected_graph(20, "tc_20.txt")