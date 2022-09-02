package com.example.employeepayrollapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid: It should have at least 2 characters starting with Capital letter.")
    public String fullName;
    @NotEmpty(message = "Profile Pic cannot be null.")
    public String profilePic;
    @NotBlank
    public String gender;
    @ElementCollection
    @CollectionTable(name = "department", joinColumns = @JoinColumn(name = "id"))
    public List<String> department;
    @Min(value = 5000, message = "salary cannot be less than 5000.")
    @Max(value = 500000, message = "Salary cannot be greater than 500000.")
    public int salary;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be a 10 digit number.")
    public String mobileNumber;
    public LocalDate startDate;
    @NotEmpty
    public String notes;
}