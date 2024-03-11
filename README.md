### `/all-student-name` test plan table results
<img width="797" alt="Screenshot 2024-03-11 120606" src="https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/8d436eb4-28ef-480e-b7d0-8357bfcdf7b5">

### `/highest-gpa` test plan table results
<img width="763" alt="Screenshot 2024-03-11 120703" src="https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/54744f9e-2840-4378-ad47-b236f44d00a2">

### `all-student-name` cmd run test result
<img width="1007" alt="Screenshot 2024-03-11 121250" src="https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/356b8cb2-30d8-47f8-b0e3-c000a7a6b11e">

### `highest-gpa` cmd run test result
<img width="989" alt="Screenshot 2024-03-11 121322" src="https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/aaa7f781-0bd5-4f57-98d1-b442909a220f">

### Performance Comparison Pre-Refactor and Post-Refactor for method `getAllStudentWithCourse`
#### Pre-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/94635986-98e9-437c-bdec-eefb12158de7)

#### Post-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/e2611993-5c93-4711-b5c0-b811f843f185)

Here, we can see significant improvements in the time it takes to run that method. Here, I implemented two loops, one for getting the students' names and IDs, and the other for getting their courses. I also implemented the use of a `HashMap` as using it allows easy grouping between the student's ID with their associated courses, and by using `HashMap` I can also optimize the lookup time as it would not take long to search for courses that don't have a student ID yet, this will be useful for adding the student ID if the course does not have it yet.

### Performance Comparison Pre-Refactor and Post-Refactor for method `findStudentWithHighestGPA`
#### Pre-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/b0b45b05-9ad1-423a-9aae-dd1c664febec)


#### Post-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/6eaa52fb-37b0-4e6b-9d4f-f1ba490599a9)

For this method, the improvement in time is not that great as I believe the original method is already efficient. However, it can still be improved, here I implemented the `.stream()` method for making the result of `.findAll()` iterable.
Then, I extract the maximum value using a `.max()` method and compare them using the `.comparingDouble()` method from the `Comparator` class 








