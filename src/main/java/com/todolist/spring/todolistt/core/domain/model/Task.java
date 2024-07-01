package com.todolist.spring.todolistt.core.domain.model;

public class Task {

    private Long id;
    private String title;
    private String description;
    private boolean iscompleted;
    private Long userId;

    public Task() {
    }

    public Task(Long id, String title, String description, boolean isCompleted, Long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.iscompleted = isCompleted;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
