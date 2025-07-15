import React from 'react';
import MedicationList from './components/MedicationList';
import RequestForm from './components/RequestForm';

function App() {
  return (
    <div style={{ padding: '2rem' }}>
      <h1>Medication Request System</h1>
      <MedicationList />
      <hr />
      <RequestForm />
    </div>
  );
}

export default App;
