import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-panel-button',
  templateUrl: './panel-button.component.html',
  styleUrls: ['./panel-button.component.css']
})
export class PanelButtonComponent {
    @Input() icon: string;
    @Input() desc: string;
}
