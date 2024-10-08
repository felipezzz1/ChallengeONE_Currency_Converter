# Currency Converter

A simple Java application that converts currencies using real-time exchange rates. The application allows users to convert between several currencies and saves the conversion history to a text file.

## Features

- Convert between the following currency pairs:
    - United States Dollar (USD) to Argentine Peso (ARS)
    - Argentine Peso (ARS) to United States Dollar (USD)
    - United States Dollar (USD) to Brazilian Real (BRL)
    - Brazilian Real (BRL) to United States Dollar (USD)
    - United States Dollar (USD) to Colombian Peso (COP)
    - Colombian Peso (COP) to United States Dollar (USD)
- Save conversion results to a text file (`conversions.txt`).
- Easy to use command-line interface.

## Requirements

- Java 11 or higher
- [Dotenv](https://github.com/cdimascio/dotenv-java) library for environment variable management
- [Gson](https://github.com/google/gson) for JSON processing
- An API key from [ExchangeRate-API](https://www.exchangerate-api.com/) to fetch exchange rates.

## Getting Started

1. **Clone the repository:**

   ```bash
   git clone https://github.com/felipezzz1/ChallengeONE_Currency_Converter.git
   cd ChallengeONE_Currency_Converter

2. **Set up your API_KEY**
    
   ```bash
   API_KEY=your_api_key

3. **Build and run the application**

   ```bash
   javac -d out src/br/com/fezor/currencyConverter/main/Main.java
   java -cp out br.com.fezor.currencyConverter.main.Main
    
## Usage

- Select the desired currency conversion option by entering the corresponding number.
- Input the amount you wish to convert when prompted.
- The result will be displayed on the screen, and conversion details will be saved to `conversions.txt`.

## Classes Overview

- **Main:** The entry point of the application, responsible for user interaction and managing the conversion process.
- **Conversion:** Represents a currency conversion, containing details such as the original amount, converted amount, and currency codes.
- **ConvertCurrency:** Handles the API request for currency conversion and returns the converted value.
- **Currency:** A record class that holds currency data (value, conversion result, base code, target code).
- **FileGenerator:** Manages the saving of conversion results in a JSON file format.
