# Appium TestNG WDIO Demo App

This repository contains a demo project for Appium automation testing using TestNG and WebDriverIO (WDIO) for the WDIO demo application. The aim is to showcase how to set up and run automated tests for mobile applications using these tools.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Running Tests](#running-tests)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Introduction

This project demonstrates how to use Appium with TestNG and WebDriverIO to automate tests for mobile applications. It provides a framework for setting up and executing tests on Android devices using the WDIO demo app.

## Features

- Automated testing using Appium and TestNG
- Integration with WebDriverIO (WDIO) for advanced test capabilities
- Sample test cases to demonstrate the framework
- Easy setup and configuration

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK 8 or later
- Node.js and npm
- Maven
- Android SDK

## Installation

To set up this project locally, follow these steps:

1. Clone the repository:

    ```bash
    git clone https://github.com/Manaf-darabseh/Appium-testng-wdiodemoapp.git
    cd Appium-testng-wdiodemoapp
    ```

2. Install the required npm packages:

    ```bash
    npm install
    ```

3. Install Maven dependencies:

    ```bash
    mvn install
    ```

## Usage

To use this project, follow these steps:

1. Start Appium server:

    ```bash
    appium
    ```

2. Run the TestNG tests:

    ```bash
    mvn test
    ```

## Running Tests

You can run the tests by executing the following command:

```bash
mvn test
