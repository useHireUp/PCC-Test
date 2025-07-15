import React, { useState } from 'react';
import { submitRequest } from '../api';

const RequestForm: React.FC = () => {
  const [patientId, setPatientId] = useState('');
  const [medicationId, setMedicationId] = useState('');

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    await submitRequest({ patientId, medicationId });
    alert('Request submitted!');
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Submit Medication Request</h2>
      <div>
        <label>Patient ID:</label>
        <input value={patientId} onChange={(e) => setPatientId(e.target.value)} required />
      </div>
      <div>
        <label>Medication ID:</label>
        <input value={medicationId} onChange={(e) => setMedicationId(e.target.value)} required />
      </div>
      <button type="submit">Submit Request</button>
    </form>
  );
};

export default RequestForm;
