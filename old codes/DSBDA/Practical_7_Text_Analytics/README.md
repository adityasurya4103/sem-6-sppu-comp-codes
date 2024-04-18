# Text Analytics with Python

## Overview

This code demonstrates some common text analytics techniques in Python using the NLTK library. It includes:

- Tokenization (word and sentence)
- Part-of-speech (POS) tagging
- Stopword removal
- Stemming
- Lemmatization

## Running the Code

To run this code, you need to have Python and the NLTK library installed.

First install NLTK:

```
pip install nltk
```

Then download the NLTK data:

```
import nltk
nltk.download('punkt')
nltk.download('stopwords')
nltk.download('averaged_perceptron_tagger')
nltk.download('wordnet')
```

Now you can run the code:

python text_analytics.py

## Explanation

### Tokenization

Tokenization splits text into tokens (words, punctuation, etc.). NLTK provides functions for word and sentence tokenization. Tokenization is an important first step in natural language processing tasks as it breaks down text into smaller units (words and sentences) that can then be further processed and analyzed.

```
from nltk import word_tokenize, sent_tokenize

word_tokens = word_tokenize(text)
sentence_tokens = sent_tokenize(text)
```

### POS Tagging

Part-of-speech (POS) tagging assigns a POS tag (noun, verb, adjective etc.) to each word. NLTK's pos_tag function does this. POS tagging labels each word with its part of speech based on its context and definition. This allows us to understand the grammatical structure of the text.

```
pos_tags = pos_tag(word_tokens)
```

### Stopword Removal

Stopwords are common words like 'a', 'and', 'the' that don't add much meaning. We can remove them with a list of stopwords. Stopword removal gets rid of frequent words that usually don't contain useful information for analysis. Removing stopwords helps reduce noise in the data.

```
from nltk.corpus import stopwords
stop_words = set(stopwords.words('english'))
cleaned_tokens = [word for word in words if word not in stop_words]
```

### Stemming

Stemming reduces words to their root form. NLTK provides several stemmer implementations, we use PorterStemmer here. Stemming simplifies words to their base form by removing affixes like prefixes and suffixes. This helps group together related words.

```
from nltk.stem import PorterStemmer
stemmer = PorterStemmer()
stems = [stemmer.stem(word) for word in words]
```

### Lemmatization

Lemmatization reduces words to their root form based on context and vocabulary (lemmatization dictionary). NLTK provides WordNetLemmatizer. Lemmatization looks at the meaning and definition of words to convert them to their base form. It is more advanced than stemming.

```
from nltk.stem import WordNetLemmatizer
lemmatizer = WordNetLemmatizer()
lemmas = [lemmatizer.lemmatize(word) for word in words]
```

This covers the main text analytics techniques shown in the code. They provide different ways to normalize, clean and process text that can be useful for many downstream NLP tasks.
