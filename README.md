# Smart Task Management API

## Project Overview

Smart Task Management API with AI-powered suggestions and n8n automation built using Spring Boot.

It allows users to manage tasks efficiently by providing:
- Task creation and tracking
- Priority management
- Deadline handling
- AI-powered task suggestions
- Automated workflows with n8n

The goal of this project is to go beyond a basic CRUD system by integrating AI and automation into task management.


## Problem Statement

Managing tasks effectively can be challenging, especially when prioritizing work and keeping track of deadlines.

Users often struggle to:
- Identify urgent tasks
- Track deadlines
- Stay consistent with task completion

This project aims to solve these problems by introducing smart suggestions and automation.

## Features

- User authentication with JWT
- Task CRUD operations
- Task prioritization
- Deadline tracking
- Category management
- Filtering and pagination
- AI-based task priority suggestions
- AI-based task summaries
- Automated reminders with n8n
- Weekly task reports

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger / OpenAPI
- OpenAI API
- n8n (workflow automation)

## Architecture

The project follows a layered architecture:

- Controller Layer (handles HTTP requests)
- Service Layer (business logic)
- Repository Layer (database access)
- DTO Layer (data transfer)
- Security Layer (JWT authentication)

## Database Design

Main entities:

- User
- Task
- Category
- NotificationLog
- AiSuggestion

Relationships:
- A user can have multiple tasks
- A task belongs to a category
- A task can have AI suggestions

## API Endpoints

### Auth
- POST /api/auth/register
- POST /api/auth/login

### Tasks
- GET /api/tasks
- POST /api/tasks
- PUT /api/tasks/{id}
- DELETE /api/tasks/{id}

### AI
- POST /api/ai/tasks/{id}/suggest-priority
- POST /api/ai/tasks/{id}/summarize

## AI Integration

The system integrates AI to enhance task management:

- Suggests task priority based on description
- Generates short summaries for tasks

## n8n Automation

n8n is used to automate workflows such as:

- Deadline reminders
- Weekly task summaries
- Overdue task notifications

These automations improve user productivity and ensure tasks are not missed.

## Status

🚧 Project is currently in development.
