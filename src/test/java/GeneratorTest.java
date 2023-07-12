
import org.example.Alphabet;
import org.example.Generator;
import org.example.Password;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    private final Password password= new Password("Secret");
    private final Alphabet firstAlphabet = new Alphabet(true,false,false,false);
    private final Alphabet secondAlphabet = new Alphabet(false,true,true,true);
    private final Alphabet thirdAlphabet = new Alphabet(true,true,true,true);
    private final Generator generator = new Generator(true,false,false,false);
//	private final Password generatedPassword = generator.GeneratePassword(4);

    @Test
    void test1() {
        Assertions.assertEquals("Secret", password.toString());
    }

    @Test
    void test2() {
        Assertions.assertEquals(firstAlphabet.getAlphabet(), Alphabet.UPPERCASE_LETTERS);
    }

    @Test
    void test3() {
        Assertions.assertEquals(secondAlphabet.getAlphabet(), Alphabet.LOWERCASE_LETTERS + Alphabet.NUMBERS + Alphabet.SYMBOLS);
    }

    @Test
    void test4() {
        Assertions.assertEquals(generator.alphabet.getAlphabet(), Alphabet.UPPERCASE_LETTERS);
    }

    @Test
    void test5() {
        Assertions.assertEquals(generator.alphabet.getAlphabet().length(), 26);
    }

    @Test
    void testPasswordCreation() {
        Password generatedPassword = generator.GeneratePassword(8);
        Assertions.assertNotNull(generatedPassword);
        Assertions.assertEquals(8, generatedPassword.toString().length());
    }

    @Test
    void testPasswordStrength() {
        Password weakPassword = new Password("abcde");
        Password strongPassword = new Password("ABcd12$%");

        Assertions.assertEquals(1, weakPassword.PasswordStrength());
        Assertions.assertEquals(5, strongPassword.PasswordStrength());
    }

    @Test
    void testGeneratedAlphabet() {
        String alphabet = generator.alphabet.getAlphabet();
        Assertions.assertNotNull(alphabet);
        Assertions.assertFalse(alphabet.isEmpty());
        Assertions.assertTrue(alphabet.contains(Alphabet.UPPERCASE_LETTERS));
        Assertions.assertFalse(alphabet.contains(Alphabet.LOWERCASE_LETTERS));
        Assertions.assertFalse(alphabet.contains(Alphabet.NUMBERS));
        Assertions.assertFalse(alphabet.contains(Alphabet.SYMBOLS));
    }

}