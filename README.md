# Step Semester 3 - Git Branching Workflow

This guide explains how this repository is structured based on the faculty's requirements and the exact Git commands to use for future assignments.

## Repository Structure

Your faculty requires a strict branching strategy:
- `main` branch: Contains this explanatory README (always empty of code).
- `develop` branch: The main integration branch where all finished work goes.
- `feature/Session_X` branches: Dedicated branches for each week/session's problems.

Inside each `feature/Session_X` branch, you have your problem files in two folders:
- `Class_Problems/`
- `assignment_Problems/`

## Step-by-Step Guide for Future Sessions

Whenever you get new work for a new session (e.g., Session 4), follow these steps in your terminal:

### 1. Make sure you are up to date
Before starting, always make sure you are on the `develop` branch and that it's updated with the latest code:
```bash
git checkout develop
git pull origin develop
```

### 2. Create your new feature branch
Create and switch to a new branch for the current session (e.g., Session 4):
```bash
git checkout -b feature/Session_4
```

### 3. Add your code
Create your new folder `Session_4` and inside it, create `Class_Problems` and `assignment_Problems`. Place your `.java` files there.

### 4. Stage and Commit
Once you are done writing your code, add all the files to Git and commit them with a descriptive message:
```bash
git add Session_4/
git commit -m "Add Session 4 class and assignment problems"
```

### 5. Push to GitHub
Finally, push your newly created branch to your remote repository on GitHub:
```bash
git push -u origin feature/Session_4
```

### 6. Merge into develop
Usually, after pushing, you would go to GitHub and create a **Pull Request (PR)** to merge `feature/Session_4` into `develop`. This completes the cycle!
