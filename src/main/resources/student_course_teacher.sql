-- Create teachers table
CREATE TABLE teachers (
                          teacherId INT PRIMARY KEY,
                          teacherName VARCHAR(100) NOT NULL
);

-- Create courses table
CREATE TABLE courses (
                         courseId INT PRIMARY KEY,
                         courseName VARCHAR(100) NOT NULL,
                         teacherId INT NOT NULL,
                         FOREIGN KEY (teacherId) REFERENCES teachers(teacherId)
);

-- Create students table
CREATE TABLE students (
                          studentId INT PRIMARY KEY,
                          studentName VARCHAR(100) NOT NULL
);

-- Create studentcourse junction table (many-to-many relationship)
CREATE TABLE studentcourse (
                               courseId INT NOT NULL,
                               studentId INT NOT NULL,
                               PRIMARY KEY (courseId, studentId),
                               FOREIGN KEY (courseId) REFERENCES courses(courseId),
                               FOREIGN KEY (studentId) REFERENCES students(studentId)
);

-- Insert sample data for teachers
INSERT INTO teachers (teacherId, teacherName) VALUES
                                                  (1, 'Dr. Smith'),
                                                  (2, 'Prof. Johnson'),
                                                  (3, 'Ms. Williams'),
                                                  (4, 'Dr. Brown');

-- Insert sample data for courses
INSERT INTO courses (courseId, courseName, teacherId) VALUES
                                                          (101, 'Mathematics', 1),
                                                          (102, 'Physics', 2),
                                                          (103, 'Chemistry', 3),
                                                          (104, 'Biology', 4),
                                                          (105, 'Computer Science', 1);

-- Insert sample data for students
INSERT INTO students (studentId, studentName) VALUES
                                                  (1, 'Alice Johnson'),
                                                  (2, 'Bob Smith'),
                                                  (3, 'Charlie Brown'),
                                                  (4, 'Diana Prince'),
                                                  (5, 'Eve Wilson'),
                                                  (6, 'Frank Miller');

-- Insert sample data for studentcourse (enrollments)
INSERT INTO studentcourse (courseId, studentId) VALUES
                                                    (101, 1),  -- Alice enrolled in Mathematics
                                                    (101, 2),  -- Bob enrolled in Mathematics
                                                    (101, 3),  -- Charlie enrolled in Mathematics
                                                    (102, 1),  -- Alice enrolled in Physics
                                                    (102, 4),  -- Diana enrolled in Physics
                                                    (103, 2),  -- Bob enrolled in Chemistry
                                                    (103, 5),  -- Eve enrolled in Chemistry
                                                    (104, 3),  -- Charlie enrolled in Biology
                                                    (104, 6),  -- Frank enrolled in Biology
                                                    (105, 1),  -- Alice enrolled in Computer Science
                                                    (105, 2),  -- Bob enrolled in Computer Science
                                                    (105, 4);  -- Diana enrolled in Computer Science