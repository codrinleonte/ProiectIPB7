import { Component } from '@angular/core';

@Component({
  selector: 'app-editexams',
  templateUrl: './editexams.component.html',
  styleUrls: ['./editexams.component.css']
})
export class EditexamsComponent {
    commissions = [
        { name: 'Comisia 1' },
        { name: 'Comisia 2' },
        { name: 'Comisia 3' },
        { name: 'Comisia 4' },
        { name: 'Comisia 5' }
    ];
}
