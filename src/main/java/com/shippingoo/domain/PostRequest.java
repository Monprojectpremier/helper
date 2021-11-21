package com.shippingoo.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
public class PostRequest {



    private static final int EXPIRATION = 30;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    private String jobTitle;
    private Double jobDuration;
    private double budget;
    private double size;
    private int numberOfPeople;

    @Column(columnDefinition="text")
    private String description;
    private String jobLocation;


    private Date dateOfWork;

    @Transient
    private MultipartFile files;


    public PostRequest(User user, Date dateOfWork) {
        this.user = user;
        this.dateOfWork = calculateExpiryDate(EXPIRATION);
    }

    private Date calculateExpiryDate (final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateOfWork.getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }



    public PostRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(Double jobDuration) {
        this.jobDuration = jobDuration;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public Date getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(Date dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFiles() {
        return files;
    }

    public void setFiles(MultipartFile files) {
        this.files = files;
    }


    @Override
    public String toString() {
        return "PostRequest{" +
                "id=" + id +
                ", user=" + user +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDuration=" + jobDuration +
                ", budget=" + budget +
                ", size=" + size +
                ", numberOfPeople=" + numberOfPeople +
                ", description='" + description + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", dateOfWork=" + dateOfWork +
                ", files=" + files +
                '}';
    }
}
