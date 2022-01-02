General:
    -HashTableDriver.java will display both hash tables, (location: # of tokens @ location).
    -Specify file for general hash table with user input, ("Enter file you would like to scan:").

GENERAL HASH TABLE:
*Size of table = 137*

Tests: (using four given test files)
*No hash table for a given file has an index (hash code) with more than six tokens "hashed" to it. 
*All hash tables except for gettysburg.txt (only has 266 tokens, shorter) are more than 90% full.

Key conversion/ hash function details-
Explanation: (for each key)
1) Converts key to all lowercase.
2) Iterates through key, one character at a time. For each character:
    -Converts character to a numerical value using character conversion class.
        ~letters a-z, numbers 1-9, and common symbols, (,.') given values 1- 38
        ~vowels and default (any other symbols) given values of primes from 37-59
    -Multiplies this numerical value by the character position in key (the index + 1). This 
    is the final character value.
3) Sums all values of characters in key.
4) Plugs into hash function: 
    -Product of: sum of characters, numerical value of first character, length of key
    -Adds numerical value of first character to this product.
5) Scales hash code to size of table using modulo 137.
    - Conditional: Checks hash table at hash code + 1 (index after current hash code). If it is
    empty, adds one to index (hash code value). If not, does nothing. 
6) Current hash code value is the final hash code (already scaled) of the specified key.

SPECIFIC HASH TABLE:
*Size of table = 50*
    -This is the smallest the hash table is able to be for the file keywords.txt. There are 50 keywords,
    therefore if the table was any smaller, there would be collisions.

Test: (using keywords.txt)
*All keys have a unique hash code and therefore map to a unique index, (every index contains one token).

Key conversion/ hash function details-
Explanation: (for each key)
1) Converts key to all lowercase.
2) Iterates through key, one character at a time. For each character:
    -Converts character to a numerical value using character conversion class.
        *SAME AS DESCRIBED ABOVE*
    -Multiplies this numerical value by the character position in key (index + 1), then adds this position
    to the value. This is the final character value.
3) Sums all values of characters in key.
4) Scales initial hash code to size of table using modulo 50.
    -There is then a series of six if conditions that execute when collisions occur.
    -Every time there is a collision, a small change is made to the current hash code, (character sum) of
    the remaining characters, (each time scaling to the size of the table w/ %50).
    -This process continues until the specified key has a unique hash code.
5) Current hash code value is the final hash code (already scaled) of the specified key.

