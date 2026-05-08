package com.ecepolat.service.impl;

import com.ecepolat.dto.task.TaskCreateRequestDto;
import com.ecepolat.dto.task.TaskResponseDto;
import com.ecepolat.dto.task.TaskStatusUpdateRequestDto;
import com.ecepolat.dto.task.TaskUpdateRequestDto;
import com.ecepolat.entity.Category;
import com.ecepolat.entity.Task;
import com.ecepolat.entity.User;
import com.ecepolat.exception.BusinessException;
import com.ecepolat.exception.ErrorCode;
import com.ecepolat.mapper.TaskMapper;
import com.ecepolat.repository.CategoryRepository;
import com.ecepolat.repository.TaskRepository;
import com.ecepolat.repository.UserRepository;
import com.ecepolat.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                            TaskMapper taskMapper,
                           UserRepository userRepository,
                           CategoryRepository categoryRepository){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    private Task findByTaskId(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.TASK_NOT_FOUND));
    }

    @Override
    public TaskResponseDto createTask(TaskCreateRequestDto request) {

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        Category category = null;

        if(request.categoryId() != null){
            category = categoryRepository.findById(request.categoryId())
                    .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
        }

        Task task = new Task();
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setStatus(request.status());
        task.setPriority(request.priority());
        task.setDueDate(request.dueDate());
        task.setUser(user);
        task.setCategory(category);

        Task savedTask = taskRepository.save(task);
        return taskMapper.toResponseDto(savedTask);
    }

    @Override
    public List<TaskResponseDto> getAllTask(User user) {

        return taskRepository.findByUserId(user.getId())
                .stream()
                .map(taskMapper::toResponseDto)
                .toList();
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {

        Task task = findByTaskId(id);
        return taskMapper.toResponseDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskUpdateRequestDto request) {
        Task task = findByTaskId(id);

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setPriority(request.priority());
        task.setDueDate(request.dueDate());

        if(request.categoryId() != null){
            Category category = categoryRepository.findById(request.categoryId())
                    .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));

            task.setCategory(category);
        }

        Task updatedTask = taskRepository.save(task);
        return taskMapper.toResponseDto(updatedTask);
    }

    @Override
    public TaskResponseDto updateTaskStatus(Long id, TaskStatusUpdateRequestDto request) {
        Task task = findByTaskId(id);

        task.setStatus(request.status());

        Task updatedTask = taskRepository.save(task);
        return taskMapper.toResponseDto(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = findByTaskId(id);
        taskRepository.delete(task);
    }
}
