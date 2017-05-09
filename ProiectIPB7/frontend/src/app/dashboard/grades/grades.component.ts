import { Component } from '@angular/core';

@Component({
  selector: 'app-grades',
  templateUrl: './grades.component.html',
  styleUrls: ['./grades.component.css']
})
export class GradesComponent {
    grades = [
        { nume: 'Carpovici', prenume: 'Andrei', grade: 8 },
        { nume: 'Vasilescu', prenume: 'Vlad', grade: 5 },
        { nume: 'Morarescu', prenume: 'George', grade: 7 },
        { nume: 'Ionscu', prenume: 'Ionut', grade: 10 },
        { nume: 'Popescu', prenume: 'Petru', grade: 9 },
        { nume: 'Georgescu', prenume: 'Maria', grade: 5 },
        { nume: 'Nicolaescu', prenume: 'Ana', grade: 6 },
        { nume: 'Rob', prenume: 'Radu', grade: 7 },
    ];
}
