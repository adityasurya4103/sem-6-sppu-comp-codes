# Data Visualization II

## Overview

This Python script uses Pandas and Seaborn to load and explore the Titanic dataset. It generates some basic visualizations to understand the data including:

- Boxplot of Age vs Gender
- Boxplot of Age vs Gender, colored by Survived

## Installation

This script requires Pandas and Seaborn. Install via pip:

pip install pandas seaborn

## Code Explanation

The script first loads and prints the Titanic dataset using Seaborn.

It then generates a boxplot showing Age on the y-axis and Gender on the x-axis. This allows us to see the distribution of Age by Gender.

Next, it makes the same boxplot but colors the boxes based on the Survived column. This allows us to see the Age distribution of those who survived vs those who did not, broken down by Gender.

Some observations:

- Women have a wider spread of Ages than Men
- The median Age for Men is higher than for Women
- Surviving Women skewed younger compared to those who did not survive
- Surviving and non-surviving Men have a more similar Age distribution
