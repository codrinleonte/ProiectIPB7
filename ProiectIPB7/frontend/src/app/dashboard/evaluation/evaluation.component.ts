import { Component } from '@angular/core';

@Component({
  selector: 'app-evaluation',
  templateUrl: './evaluation.component.html',
  styleUrls: ['./evaluation.component.css']
})
export class EvaluationComponent {
    students = [
        { name: 'Georgescu I. Anton' },
        { name: 'Marinescu D. George-Vlad' },
        { name: 'Vasilache E. Maria' },
        { name: 'Tutu F. Robert-Ionut' },
        { name: 'Voicu G. Cristi-Petru' },
        { name: 'Mosu G. George' }
    ];
}
