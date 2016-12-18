package com.example.login.model;

/**
 * Created by ON-ONE on 12/18/2016.
 */
public class user{
        private String mName;
        private String mUsername;
        private String mPassword;

        public user(String name, String username, String password) {
            this.mName = name;
            this.mUsername = username;
            this.mPassword = password;
        }

        public String getName() {
            return mName;
        }
        public String getPhone() {
            return mUsername;
        }
        public String getImage() {
            return mPassword;
        }

        @Override//เพิ่มเข้ามา
        public String toString() {
            return mName;
        }
    }

