import React, { useState } from 'react'
import 'bootstrap/dist/css/bootstrap.min.css';

export default function MyForm() {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    gender: "",
    age: "",
    address: {
      state: "",
      city: "",
      pin: ""
    }
  });

  const validate = () => {
    let newErrors = {};

    if (!formData.firstName.trim())
      newErrors.firstName = "First name is required";

    if (!formData.lastName.trim())
      newErrors.LastName = "Last name is required";


    if (!formData.email.includes("@"))
      newErrors.email = "Valid email required";

    if (formData.phone.length !== 10)
      newErrors.phone = "Phone must be 10 digits";

    if (!formData.gender)
      newErrors.gender = "Select gender";

    if (formData.age > 10 && formData.age <= 100)
      newErrors.age = "Age must be valid";

    if (!formData.address.pin)
      newErrors.pin = "PIN required";

    return newErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const validationErrors = validate();
    console.log(validationErrors)
    if (Object.keys(validationErrors).length > 0) {
      setErrors(validationErrors);
    } else {
      console.log("Form Submitted", formData);
      setErrors({});
    }
  };

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (["state", "city", "pin"].includes(name)) {
      setFormData({
        ...formData,
        address: {
          ...formData.address,
          [name]: value
        }
      });
    } else {
      setFormData({
        ...formData,
        [name]: value
      });
    }
  };

  return (
    <div>
      <form className="container mt-2 p-4 shadow rounded bg-light">
        <h2 className="mb-4 text-center">User Registration</h2>

        <div className="row">
          <div className="col-md-6 mb-3">
            <label className="form-label">First Name</label>
            <input type="text" className={`form-control ${errors.firstName ? "is-invalid" : ""}`} name="firstName" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.firstName}
            </div>
          </div>


          <div className="col-md-6 mb-3">
            <label className="form-label">Last Name</label>
            <input type="text" className={`form-control ${errors.lastName ? "is-invalid" : ""}`} name="lastName" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.lastName}
            </div>
          </div>

        </div>

        <div className="row">
          <div className="col-4 mb-3">
            <label className="form-label">Email</label>
            <input type="email" className={`form-control ${errors.email ? "is-invalid" : ""}`} name="email" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.email}
            </div>
          </div>



          <div className="col-4 mb-3">
            <label className="form-label">Phone Number</label>
            <input type="tel" className={`form-control ${errors.phone ? "is-invalid" : ""}`} name="phone" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.phone}
            </div>
          </div>


          <div className="col-4 mb-3">
            <label className="form-label">Age</label>
            <input type="number" className={`form-control ${errors.age ? "is-invalid" : ""}`} name="age" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.age}
            </div>

          </div>

        </div>

        <h5 className="mt-4">Address</h5>

        <div className="row">
          <div className="col-md-4 mb-3">
            <label className="form-label">State</label>
            <input type="text" className={`form-control ${errors.state ? "is-invalid" : ""}`} name="state" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.state}
            </div>
          </div>

          <div className="col-md-4 mb-3">
            <label className="form-label">City</label>
            <input type="text" className={`form-control ${errors.city ? "is-invalid" : ""}`} name="city" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.city}
            </div>
          </div>

          <div className="col-md-4 mb-3">
            <label className="form-label">PIN</label>
            <input type="text" className={`form-control ${errors.pin ? "is-invalid" : ""}`} name="pin" onChange={handleChange} />
            <div className="invalid-feedback">
              {errors.pin}
            </div>
          </div>
        </div>

        <div className="row">
          <div className="col-md-6 mb-3">
            <label className="form-label d-block">Gender</label>
            <div className="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="gender" value="male" />
              <label className="form-check-label">Male</label>
            </div>
            <div className="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="gender" value="female" />
              <label className="form-check-label">Female</label>
            </div>
            <div className="form-check form-check-inline">
              <input className="form-check-input" type="radio" name="gender" value="other" />
              <label className="form-check-label">Other</label>
            </div>
          </div>
        </div>

        <div className="text-center mt-4">
          <button type="submit" className="btn btn-primary px-5" onClick={(e) => handleSubmit(e)}>
            Submit
          </button>
        </div>
      </form>

    </div>
  )
}
