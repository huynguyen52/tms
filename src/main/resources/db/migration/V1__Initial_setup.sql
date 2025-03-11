-- V1__Initial_setup.sql

-- Create Users Table
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       first_name VARCHAR(255),
                       last_name VARCHAR(255),
                       email VARCHAR(255),
                       role VARCHAR(20) NOT NULL
);

-- Create Boards Table
CREATE TABLE boards (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description TEXT,
                        owner_id BIGINT,
                        CONSTRAINT fk_owner FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Create Projects Table
CREATE TABLE projects (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          owner_id BIGINT,
                          CONSTRAINT fk_owner_project FOREIGN KEY (owner_id) REFERENCES users(id) ON DELETE SET NULL
);

-- Create Tasks Table
CREATE TABLE tasks (
                       id BIGSERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       status VARCHAR(20),
                       priority VARCHAR(20),
                       due_date DATE,
                       user_id BIGINT,
                       board_id BIGINT,
                       project_id BIGINT,
                       CONSTRAINT fk_user_task FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL,
                       CONSTRAINT fk_board_task FOREIGN KEY (board_id) REFERENCES boards(id) ON DELETE CASCADE,
                       CONSTRAINT fk_project_task FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
);
