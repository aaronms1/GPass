package generator;

import java.security.SecureRandom;

import java.util.*;
import java.util.stream.*;

    /**
     * <ul>
     *     <li>{@link PasswordFactory} is a class that generates a random
     *     password using the {@link SecureRandom}. class</li>
     * </ul>
     */
    public class PasswordFactory {
//    String randPass = generateSecurePassword();
        public static void main(String[] args) {
            System.out.println(generateSecurePassword());
        }

//        /**
//         * Displays an ascii art of a password generator while generating a
//         * password.
//         */
//        static final String passGen =
//                ("""
//                         _ __                              _ __                                   ,___      \s
//                        ( /  )               /            ( /  )                            /    /   /      \s
//                         /--<  __,  _ _   __/ __ _ _ _     /--'__,  (   (   , , , __ _   __/    /  ___  _ _ \s
//                        /   \\_(_/(_/ / /_(_/_(_)/ / / /_  /   (_/(_/_)_/_)_(_(_/_(_)/ (_(_/_   (___/(/_/ / /_
//                         \n""");

        /**
         * Displays a little hint about the  security of passwords.
         */
        static final String hint =
                ("""
                              Anything under 32 characters is not recommended!!!
                        Random words with special delimiters are even better!!
                                 Generating a random 32character password...
                         """);

        /**
         * METHOD:
         * <ul>
         *     <li>{@link PasswordFactory#generateSecurePassword()}
         *     </li>
         * </ul>
         * Generates a random password with letters, numbers, and symbols, using
         * the {@link SecureRandom} class.
         */
        public static String generateSecurePassword() {
            Stream<Character> demPass =
                    Stream.concat(getRandomNumbers(8),
                            Stream.concat(getRandomSpecialChars(8),
                                    Stream.concat(getRandomAlphabets(8, true),
                                            getRandomAlphabets(8, false))));
            List<Character> listOfChar = demPass.collect(Collectors.toList());
            Collections.shuffle(listOfChar);
            System.out.println(/*passGen + */hint);
            return listOfChar.stream()
                    .collect(
                            StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        }

        /**
         * METHOD:
         * <ul>
         *     <li>{@link PasswordFactory#getRandomSpecialChars(int)}
         *     </li>
         * </ul>
         * Generates a random number with the specified length.
         *
         * @param length the length of the number
         * @return a random number
         */
        public static Stream<Character> getRandomSpecialChars(int length) {
            Stream<Character> specialCharsStream;
            Random random = new SecureRandom();
            IntStream specialChars =
                    random.ints(length, 33, 45);
            specialCharsStream = specialChars.mapToObj(data -> (char) data);

            return specialCharsStream;
        }

        /**
         * METHOD:
         * <ul>
         *     <li>{@link PasswordFactory#getRandomNumbers(int)}
         *     </li>
         * </ul>
         * Generates a random number with the specified length.
         *
         * @param length the length of the number
         * @return a random number
         */
        public static Stream<Character> getRandomNumbers(int length) {
            Stream<Character> numberStream;
            Random random = new SecureRandom();
            IntStream numberIntStream =
                    random.ints(length, 48, 57);
            numberStream = numberIntStream.mapToObj(data -> (char) data);

            return numberStream;
        }

        /**
         * METHOD:
         * <ul>
         *     <li>{@link PasswordFactory#getRandomAlphabets(int, boolean)}
         *     </li>
         * </ul>
         * Generates a random alphabet with the specified length.
         *
         * @param length the length of the alphabet
         * @param check  true if the alphabet is uppercase, false if lowercase
         * @return a random alphabet
         */
        public static Stream<Character> getRandomAlphabets(int length, boolean check) {
            Stream<Character> lowerUpperStream;
            if (check) {
                Random random = new SecureRandom();
                IntStream lCaseStream =
                        random.ints(length, 'a', 'z');
                lowerUpperStream = lCaseStream.mapToObj(data -> (char) data);
            } else {
                Random random = new SecureRandom();
                IntStream uCaseStream = random.ints(length, 'A', 'Z');
                lowerUpperStream = uCaseStream.mapToObj(data -> (char) data);
            }
            return lowerUpperStream;
        }

        @Override
        public String toString() {
            return "PasswordGenerator{" +
                    '}';
        }
    }
