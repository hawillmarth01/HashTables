public class CharacterConversion{
    //converts a character to a numeric value using switch statement, postCondition = returns value of converted character
    public static int convertCharacter(char l){
        char character = l;
        int converted;
        switch (character){
            //lowercase letters
            case 'a':
                converted = 37;
                break;

            case 'b':
                converted = 2;
                break;

            case 'c':
                converted = 3;
                break;

            case 'd':
                converted = 4;
                break;

            case 'e':
                converted = 41;
                break;

            case 'f':
                converted = 6;
                break;

            case 'g':
                converted = 7;
                break;

            case 'h':
                converted = 8;
                break;

            case 'i':
                converted = 43;
                break;

            case 'j':
                converted = 10;
                break;

            case 'k':
                converted = 11;
                break;

            case 'l':
                converted = 12;
                break;

            case 'm':
                converted = 13;
                break;

            case 'n':
                converted = 14;
                break;

            case 'o':
                converted = 47;
                break;

            case 'p':
                converted = 16;
                break;

            case 'q':
                converted = 17;
                break;

            case 'r':
                converted = 18;
                break;

            case 's':
                converted = 19;
                break;

            case 't':
                converted = 20;
                break;

            case 'u':
                converted = 53;
                break;

            case 'v':
                converted = 22;
                break;

            case 'w':
                converted = 23;
                break;

            case 'x':
                converted = 24;
                break;

            case 'y':
                converted = 25;
                break;

            case 'z':
                converted = 26;
                break;
            //digits
            case '1':
                converted = 27;
                break;

            case '2':
                converted = 28;
                break;

            case '3':
                converted = 29;
                break;

            case '4':
                converted = 30;
                break;

            case '5':
                converted = 31;
                break;

            case '6':
                converted = 32;
                break;

            case '7':
                converted = 33;
                break;

            case '8':
                converted = 34;
                break;

            case '9':
                converted = 35;
                break;

            //common symbols
            case ',':
                converted = 36;
                break;

            case '.':
                converted = 37;
                break;

            case '\'':
                converted = 38;
                break;

            //other symbol
            default: 
                converted = 59;
        }
    return converted;
    }
}