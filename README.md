Like Hero To Zero - Sustainability Project
This project is a web application prototype developed for the "Like Hero To Zero" sustainability initiative. The goal is to create a platform that displays publicly accessible data on global CO2 emissions, while offering a secure backend for registered scientists to manage and update the data.

Key Features:
Public CO2 Emissions Data: The homepage displays the most recent CO2 emissions data for each country, accessible without requiring a login.
Scientist Dashboard: Registered scientists can log in to add new climate research data or correct existing data.

Technology Stack:
Frontend: JSF with CDI/Beans
Backend: JPA with Hibernate for data persistence
Database: MySQL



Open MYSQL Workbench and create database as follows;

1. create_database

CREATE DATABASE IF NOT EXISTS like_hero_to_zero;
USE like_hero_to_zero;


2. create_tables

USE like_hero_to_zero;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS co2_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50) NOT NULL,
    year INT NOT NULL,
    emissions DECIMAL(10, 2) NOT NULL,
    submitted_by INT,
    FOREIGN KEY (submitted_by) REFERENCES users(id)
);
