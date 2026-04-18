## User

- id
- name
- email
- password
- role
- createdAt

## Task

- id
- title
- description
- status
- priority
- dueDate
- userId
- categoryId
- createdAt
- updatedAt

## Category

- id
- name
- userId

## NotificationLog

- id
- userId
- taskId
- type
- message
- sentAt

## AiSuggestion

- id
- taskId
- suggestedPriority
- summary
- createdAt

• One User -> Many Tasks
• One User -> Many Categories
• One Category -> Many Tasks
