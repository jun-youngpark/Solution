package level1;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateNewId_java {

        public String solution(String new_id) {
            return NewIdFactory.createFrom(new_id)
                    .getNewId();
        }

        private static class NewIdFactory {
            public static NewId createFrom(String newId) {
                return new NewId(newId)
                        .toLowerCase()
                        .removeInvalidLetters()
                        .replaceMultipleDots()
                        .removeSideDotsIfPresent()
                        .replaceIfEmpty()
                        .removeOverloads()
                        .removeBackDotsIfPresent()
                        .appendInsufficientLetters();
            }
        }

        private static class NewId {
            private static final String REMOVAL_REGEX = "[^a-z0-9\\-_.]";
            private static final String DEFAULT_ID = "a";
            private static final Integer MAX_LENGTH = 15;
            private static final Integer MIN_LENGTH = 3;
            private final String newId;

            public NewId(String newId) {
                this.newId = newId;
            }

            public NewId toLowerCase() {
                return new NewId(newId.toLowerCase());
            }

            public NewId removeInvalidLetters() {
                return new NewId(newId.replaceAll(REMOVAL_REGEX, ""));
            }

            public NewId replaceMultipleDots() {
                StringBuilder builder = new StringBuilder();

                for (int i = 0, length = newId.length(); i < length; i++) {
                    if (newId.charAt(i) == '.') {
                        while (i < length && newId.charAt(i) == '.') {
                            i++;
                        }

                        builder.append(".");
                        i--;
                        continue;
                    }

                    builder.append(newId.charAt(i));
                }

                return new NewId(builder.toString());
            }

            public NewId removeSideDotsIfPresent() {
                return removeFrontDotsIfPresent().removeBackDotsIfPresent();
            }

            public NewId removeFrontDotsIfPresent() {
                if (newId.startsWith(".")) {
                    return new NewId(newId.substring(1));
                }

                return this;
            }

            public NewId removeBackDotsIfPresent() {
                if (newId.endsWith(".")) {
                    return new NewId(newId.substring(0, newId.length() - 1));
                }

                return this;
            }

            public NewId replaceIfEmpty() {
                if (newId.isEmpty()) {
                    return new NewId(DEFAULT_ID);
                }

                return this;
            }

            public NewId removeOverloads() {
                if (newId.length() > MAX_LENGTH) {
                    return new NewId(newId.substring(0, MAX_LENGTH));
                }

                return this;
            }

            public NewId appendInsufficientLetters() {
                if (newId.length() < MIN_LENGTH) {
                    String appendedId;
                    appendedId = IntStream.range(0, MIN_LENGTH - newId.length())
                            .mapToObj(i -> String.valueOf(newId.charAt(newId.length() - 1)))
                            .collect(Collectors.joining());

                    return new NewId(newId.concat(appendedId));
                }

                return this;
            }

            public String getNewId() {
                return newId;
            }
        }



    public static void main(String[] args) {
         CreateNewId_java id = new CreateNewId_java();
         id.solution(".....");

    }

}
