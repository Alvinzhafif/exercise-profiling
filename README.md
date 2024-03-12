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
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/62d57c27-b0f6-4ff8-9f01-cb19f228ac98)


ramp up p
#### Post-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/6eaa52fb-37b0-4e6b-9d4f-f1ba490599a9)

For this method, the improvement in time is not that great as I believe the original method is already efficient. However, it can still be improved, here I implemented the `.stream()` method for making the result of `.findAll()` iterable.
Then, I extract the maximum value using a `.max()` method and compare them using the `.comparingDouble()` method from the `Comparator` class 


### Performance Comparison Pre-Refactor and Post-Refactor for method `joinStudentNames`
#### Pre-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/477142c5-111e-4b06-86e7-8ecae569e9c8)

#### Post-Optimization
![image](https://github.com/Alvinzhafif/exercise-profiling/assets/143392835/5a5652f4-817e-48f4-9912-d3b473d8d697)

For this method, I made significant improvements to the running time. Now, there is about 80% improvement in running time compared to pre-optimization. Here, like the `findStudentWithHighestGpa` function, I implemented the use of the `.stream()` method. Then I used `.map()` for transforming the stream objects and `.collect` for collecting the elements into a single string. A `Collector` is also used for combining the names.

1. Both can be used for testing and improving the performance. However, there are some differences in their approach to the tests themselves:
   * JMeter test
     <br>
     Usually, the JMeter test is used to see if the app can perform under heavy and various load conditions. In addition, it can identify bottlenecks, measure response time, and determine the overall scalability. The test scenario can include, the number of users, ramp-up period, and request type. This can help determine how much time it takes for your algorithm to run the code and how long it takes to access the database as well.

   * IntelliJ Profiler
     <br>
     Whilst the Profiler is commonly used for pinpointing specific areas of code that can be improved. So it's more focused on CPU usage and method execution time, from there they can then pinpoint the running time of the specific method and the developer (Us) can easily make improvements to that specific segment only. Profiler also has a few different visualizations so the developer can take a look at how his methods run in different point of views.

  








