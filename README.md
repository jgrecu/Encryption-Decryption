# Encryption-Decryption

## About
Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure that no-one but the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example! Don’t stay behind: hop on the encryption/decryption train and learn the essential basics while implementing this simple project.

## Description
The program must parse two additional arguments -in and -out to specify the full name of a file to read data and to write the result. Arguments -mode, -key, and -data should still work as before.

Your program should read data from -data or from a file written in the -in argument. That's why you can't have both -data and -in arguments simultaneously, only one of them.

    If there is no -mode, the program should work in enc mode.
    If there is no -key, the program should consider that key = 0.
    If there is no -data, and there is no -in the program should assume that the data is an empty string.
    If there is no -out argument, the program must print data to the standard output.
    If there are both -data and -in arguments, your program should prefer -data over -in.

If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program should not fail. Instead, it must display a clear message about the problem and stop successfully. The message should contain the word "Error" in any case.

When starting the program, the necessary algorithm should be specified by an argument (-alg). The first algorithm should be named shift, the second one should be named unicode. If there is no -alg you should default it to shift.

Remember that in case of shift algorithm you need to encode only English letters (from 'a' to 'z' as the first circle and from 'A' to 'Z' as the second circle i.e. after 'z' comes 'a' and after 'Z' comes 'A').

## Examples

### Example 1

```java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode```

This command must get data from the file road_to_treasure.txt, encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

### Example 2

Input:

```java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode```

Output:

```\jqhtrj%yt%m~ujwxpnqq&```

### Example 3

Input:

```java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec```

Output:

```Welcome to hyperskill!```

### Example 4:

Input:

```java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc```

Output:

```Bjqhtrj yt mdujwxpnqq!```

### Example 5:

Input:

```java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec```

Output:

```Welcome to hyperskill!```

