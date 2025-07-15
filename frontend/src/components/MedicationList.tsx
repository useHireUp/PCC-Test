import React, { useEffect, useState } from 'react';
import { getMedications } from '../api';

interface Medication {
  id: number;
  name: string;
  dosage: string;
}

const MedicationList: React.FC = () => {
  const [medications, setMedications] = useState<Medication[]>([]);

  useEffect(() => {
    getMedications().then(setMedications);
  }, []);

  return (
    <div>
      <h2>Available Medications</h2>
      <ul>
        {medications.map((med) => (
          <li key={med.id}>
            {med.name} – {med.dosage}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MedicationList;
