Project 1 - Implement a lexical analyzer for a simplified java programming language
(1) Define tokens (e.g., token names) for a simplified Java programming language
(2) Make regular expressions which describe the patterns of the tokens 
(3) Construct a NFA (Nondeterministic Finite Automata) for the regular expressions
(4) Translate the NFA to DFA (Deterministic Finite Automata), especially in the form of a table
(5) Implement a program which does a lexical analysis (recognizing tokens).


Project 2 - Implement a bottom-up syntax analyzer 
- The execution flow of your syntax analyzer:
- ./lexical_analyzer <input_file_name>
- ./syntax_analyzer <output_of_your_lexical_analyzer>
: You can internally pass your input from your lexical analyzer to your syntax analyzer.

- Input: an output of your lexical analyzer program

- Output: just an acceptance message
- (if an output is ‘reject’) please make an error report which explains why and where the error 
occurred (e.g., line number)