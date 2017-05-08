import { Component } from '@angular/core';

@Component({
  selector: 'app-managestuds',
  templateUrl: './managestuds.component.html',
  styleUrls: ['./managestuds.component.css']
})
export class ManagestudsComponent {
    students = [
        { name: 'Ion D. Vladut' },
        { name: 'Gheorgiu S. Iulian' },
        { name: 'Stuica D. Stefania' },
        { name: 'Miron E. Codrin' },
        { name: 'Vasile F. Vladut' },
        { name: 'Georgescu D. Stefan' },
        { name: 'Ion D. Maria' }
    ];
}
