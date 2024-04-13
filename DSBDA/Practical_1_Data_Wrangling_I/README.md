# Data Wrangling

## Requirements

- Python
- Pandas
- NumPy
- Matplotlib

## Installation

Install the required dependencies:

```bash
pip install pandas numpy matplotlib
```

## Usage

1. Place the dataset `autodata.csv` in the same directory as the script.
2. Run the File `DataWrangling.py`

## Results

The script performs the following tasks:

- Loads the dataset `autodata.csv`.
- Displays basic information about the dataset including data types and non-null values.
- Describes statistical summary of the dataset.
- Shows the first 10 and last 5 rows of the dataset.
- Preprocesses the data by handling missing values.
- Standardizes the data.
- Normalizes the data.
- Converts categorical variables into numerical variables.
- Bins the 'horsepower' column into three bins: Low, Medium, and High.
- Visualizes the binned 'horsepower' data using a histogram and a bar plot.
