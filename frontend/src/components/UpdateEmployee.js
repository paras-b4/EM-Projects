import EmployeeService from '../services/EmployeeService';
import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateEmployee = () => {
    const { id } = useParams();  // Get ID from URL
    const navigate = useNavigate();  // For navigation
    const [employee, setEmployee] = useState({
        id:id,
        name: "",
        phone: "",
        email: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEmployee({ ...employee, [name]: value });
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await EmployeeService.getEmployeeById(employee.id); // Use `id` directly
                setEmployee(response.data);
            } catch (error) {
                console.error("Error fetching employee:", error);
            }
        };
        fetchData();
    }, []);  // Add `id` as dependency

    const UpdateEmployee = (e) => {
        e.preventDefault();
        EmployeeService.UpdateEmployee(employee, id)  // Correct camelCase for function
            .then((response) => {
                console.log("Employee updated:", response);
                navigate("/")
            })
            .catch((error) => {
                console.error("Error updating employee:", error);
            })
    }

    return (
        <div className='max-w-xl mx-30 bg-slate-700 my-10 rounded shadow py-2 px-4 rounded'>
            <div className='text-4xl tracking-wider font-bold text-center py-4 px-8'>
                <p> 👨‍💻 Update Employee</p>
            </div>
            <div className='mx-10 my-2'>
                <input
                    type='text'
                    name='name'
                    value={employee.name}
                    onChange={handleChange}
                    className="w-full py-2 my-4 text-slate-800"
                    placeholder='Name'
                    key={id}  // Ensure correct rendering of input
                />
                <input
                    type='number'
                    name='phone'
                    value={employee.phone}
                    onChange={handleChange}
                    className="w-full py-2 my-4 text-slate-800"
                    placeholder='Phone'
                    key={id}  // Ensure correct rendering of input
                />
                <input
                    type='email'
                    name='email'
                    value={employee.email}
                    onChange={handleChange}
                    className="w-full py-2 my-4 text-slate-800"
                    placeholder='Email'
                    key={id}  // Ensure correct rendering of input
                />
            </div>
            <div className='flex my-4 space-x-4 px-20'>
                <button
                    onClick={UpdateEmployee}
                    className='bg-green-400 hover:bg-pink-700 py-2 px-6 rounded'>
                    Update
                </button>
                <button
                    onClick={() => navigate("/")}
                    className='bg-red-400 hover:bg-pink-700 py-2 px-6 rounded'>
                    Cancel
                </button>
            </div>
        </div>
    );
};

export default UpdateEmployee


