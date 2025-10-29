CREATE SCHEMA IF NOT EXISTS user;
CREATE SCHEMA IF NOT EXISTS user_history;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
SET search_path TO user,user_history,public