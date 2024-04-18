# Iris Data Analysis

## Overview

This code loads the iris dataset, splits it into training and test sets, scales the features, trains a Naive Bayes classifier model, makes predictions on the test set, and analyzes the model performance.

Key steps:

- Load iris dataset
- Split data into train/test sets
- Standard scale features
- Train Naive Bayes classifier
- Make predictions on test set
- Map predictions to integers
- Plot regression lines comparing predictions vs actual values
- Print confusion matrix and classification report

## Running the Code

To run this code:

1. Install requirements: pandas, numpy, matplotlib, seaborn, sklearn

2. Run Data_Analytics.py

The output will include dataframe info, statistics, model training and evaluation results.

## Explanation

The dataframe is loaded from the iris CSV file and basic info and statistics are printed.

The data is split into feature data (X) and target data (Y). It is then split into training and test sets and the features are standardized.

A Naive Bayes classifier model is trained on the training data and makes predictions on the test data.

The predictions are mapped to integers and regression lines are plotted to compare the predicted species to the actual species for each feature. This shows how the model performs at predicting species from individual features.

Finally, the confusion matrix and classification report are printed to evaluate the model accuracy, precision, recall etc.

The Naive Bayes model achieves reasonable accuracy on this dataset, but struggles to perfectly separate the different iris species based on the 4 features. The regression plots indicate it does best using the petal features compared to sepal features.
