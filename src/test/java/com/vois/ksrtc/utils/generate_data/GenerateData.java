package com.vois.ksrtc.utils.generate_data;

import com.github.javafaker.Faker;

public class GenerateData{

        private final Faker faker;

        public GenerateData() {
            this.faker = new Faker();
        }

        public String generateEmail() {
            return faker.internet().emailAddress();
        }

        public String generatePassword() {
            String password = faker.internet().password(8, 16);
            while (password.length() < 8) {
                password = faker.internet().password(8, 16);
            }
            return password;
        }

        public int generateAge(){
            return faker.number().numberBetween(24,65);
        }

        public String generatePassengerName(){
            return faker.name().fullName();
        }
}

