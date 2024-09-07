/*
YEXT India Limited

Question:
Consider the following React class component that manages a form with fields for a credit card. 
The component performs validation and provides feedback to users based on their input.

Validation criteria:
Card number- required, 16 digits, error: invalid car number
Carholder name- required, only English alphabetic lettes, invalid cardholder name
Expiration month: required, must be 2 digit number between 01 January to 12 December, invalid month
Expiration year: required, must be a 4 digit number with greater than or equal to current year with a max difference of 3 years from current year, invalid year
CVV/CVC - required,must be 3 digit number, invalid CVV/CVC 


Implementation :
FormComponent.js should have all the logic for card input field, error msges, and submit button.implement handlechange to capture user input for each field.
Implement validation logic based on specified criteria. Display proper error msg corresponding to data-testids
Initially disable the submit button. Enable when all fields are filled and valid.
Validation should trigger when user touch the field for first time.(Becomes touched)
Error msg and submit button behaviour are driven by validation state of each field.
 */
import React, { Component } from 'react';

export default class FormComponent extends Component {
    constructor(props) {
        super(props);
        this.state = {
            formData: {
                cardNumber: '',
                cardHolderName: '',
                expirationMonth: '',
                expirationYear: '',
                cvv: ''
            },
            errors: {
                cardNumber: '',
                cardHolderName: '',
                expirationMonth: '',
                expirationYear: '',
                cvv: ''
            },
            touched: {
                cardNumber: false,
                cardHolderName: false,
                expirationMonth: false,
                expirationYear: false,
                cvv: false
            }
        };

        this.currentYear = new Date().getFullYear();
    }

    validate = {
        cardNumber: value => {
            if (!value) return 'Card number is required';
            if (!/^\d{16}$/.test(value)) return 'Invalid card number';
            return '';
        },
        cardHolderName: value => {
            if (!value) return 'Cardholder name is required';
            if (!/^[A-Za-z\s]+$/.test(value)) return 'Invalid cardholder name';
            return '';
        },
        expirationMonth: value => {
            if (!value) return 'Expiration month is required';
            if (!/^(0[1-9]|1[0-2])$/.test(value)) return 'Invalid month';
            return '';
        },
        expirationYear: value => {
            if (!value) return 'Expiration year is required';
            if (!/^\d{4}$/.test(value) || value < this.currentYear || value > this.currentYear + 3) return 'Invalid year';
            return '';
        },
        cvv: value => {
            if (!value) return 'CVV/CVC is required';
            if (!/^\d{3}$/.test(value)) return 'Invalid CVV/CVC';
            return '';
        }
    };

    handleChange = e => {
        const { name, value } = e.target;
        this.setState(prevState => ({
            formData: {
                ...prevState.formData,
                [name]: value
            },
            errors: {
                ...prevState.errors,
                [name]: this.validate[name](value)
            }
        }));
    };

    handleBlur = e => {
        const { name } = e.target;
        this.setState(prevState => ({
            touched: {
                ...prevState.touched,
                [name]: true
            },
            errors: {
                ...prevState.errors,
                [name]: this.validate[name](prevState.formData[name])
            }
        }));
    };

    isFormValid = () => {
        const { errors, formData } = this.state;
        return Object.values(errors).every(error => !error) && Object.values(formData).every(field => field);
    };

    handleSubmit = e => {
        e.preventDefault();
        if (this.isFormValid()) {
            console.log('Form submitted:', this.state.formData);
        } else {
            console.log('Form has errors');
        }
    };

    render() {
        const { formData, errors, touched } = this.state;

        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label htmlFor="cardNumber">Card Number</label>
                    <input
                        id="cardNumber"
                        name="cardNumber"
                        type="text"
                        data-testid="number-input"
                        value={formData.cardNumber}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                    />
                    {touched.cardNumber && errors.cardNumber && (
                        <span data-testid="number-input-error">{errors.cardNumber}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="cardHolderName">Cardholder Name</label>
                    <input
                        id="cardHolderName"
                        name="cardHolderName"
                        type="text"
                        data-testid="name-input"
                        value={formData.cardHolderName}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                    />
                    {touched.cardHolderName && errors.cardHolderName && (
                        <span data-testid="name-input-error">{errors.cardHolderName}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="expirationMonth">Expiration Month</label>
                    <input
                        id="expirationMonth"
                        name="expirationMonth"
                        type="text"
                        data-testid="month-input"
                        value={formData.expirationMonth}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                    />
                    {touched.expirationMonth && errors.expirationMonth && (
                        <span data-testid="month-input-error">{errors.expirationMonth}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="expirationYear">Expiration Year</label>
                    <input
                        id="expirationYear"
                        name="expirationYear"
                        type="text"
                        data-testid="year-input"
                        value={formData.expirationYear}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                    />
                    {touched.expirationYear && errors.expirationYear && (
                        <span data-testid="year-input-error">{errors.expirationYear}</span>
                    )}
                </div>
                <div>
                    <label htmlFor="cvv">CVV/CVC</label>
                    <input
                        id="cvv"
                        name="cvv"
                        type="text"
                        data-testid="cvv-input"
                        value={formData.cvv}
                        onChange={this.handleChange}
                        onBlur={this.handleBlur}
                    />
                    {touched.cvv && errors.cvv && (
                        <span data-testid="cvv-input-error">{errors.cvv}</span>
                    )}
                </div>
                <button type="submit" data-testid="submit-button" disabled={!this.isFormValid()}>
                    Submit
                </button>
            </form>
        );
    }
}
