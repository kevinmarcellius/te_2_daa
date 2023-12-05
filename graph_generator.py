def generate_graph(vertices, filename):
   with open(filename, 'w') as f:
       f.write(f"{vertices}\n")
       for i in range(vertices):
           for j in range(vertices):
               if i != j:
                  f.write(f"{i} {j}\n")

generate_graph(5, 'tc_5x.txt')

