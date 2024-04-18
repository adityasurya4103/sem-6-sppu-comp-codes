# DataAnalytics.py

This Python script performs some basic data analytics and visualization on the Titanic dataset using Pandas, Seaborn, and Matplotlib.

## Overview

The script loads the Titanic dataset from Seaborn and prints out the first few rows to display the structure. It then sets the Seaborn style to "whitegrid" for nicer plot styling.

Two visualizations are created:

1. A bar plot showing survival rate by gender and passenger class. This uses the `sns.catplot()` function.

2. A histogram of ticket prices using `sns.histplot()`.

## Running the Code

To run this script, you need Python 3 along with Pandas, Seaborn, and Matplotlib installed.

Simply execute:

python DataAnalytics.py

This will load the data, create the plots, and display them.

## Explanation

The bar plot clearly shows that females had a much higher survival rate than males, especially for the First and Second class passengers. The Third class females still had a noticeable higher survival rate than the males.

The ticket price histogram shows the distribution of fares paid. It's right skewed, meaning most passengers paid low fares, with a long tail to the right of higher fares. The peak frequency is around 10.

Together, these visualizations help uncover patterns in the Titanic dataset regarding survival rates and ticket prices. The code provides a simple starting point for further data analysis and visualization.
