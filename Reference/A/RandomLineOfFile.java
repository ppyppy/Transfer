////
//Suppose I give you a text file and ask you a to write a program that will return a random line from
//the file (all lines must have equal probability to be returned)
//
//Same as part 1, except this time the entire text file cannot fit into main memory

//Most simple: 
//	Count the lines, choose a line number at random, go through the file a second time and return it.
//

//Best way:
i = 1	
chosen_line = ""
for line in lines:
    if random() < 1/i:    # random returns a uniform random number in [0,1)
        chosen_line = line
    i += 1
    
return chosen_line