import { Component, Input } from '@angular/core';
import { trigger, state, style, transition, animate } from "@angular/animations";

@Component({
    selector: 'app-panel-button',
    templateUrl: './panel-button.component.html',
    styleUrls: ['./panel-button.component.css'],
    animations: [
        trigger('glowAnim', [
            state('hidden', style({ 'box-shadow': 'none' })),
            state('visible', style({ 'box-shadow': '0px 0px 20px #0054ff'})),
            transition('hidden => visible', animate('300ms ease-in')),
            transition('visible => hidden', animate('300ms ease-out'))
        ])
    ]
})
export class PanelButtonComponent {
    @Input() icon: string;
    @Input() desc: string;

    animState: string = 'hidden';

    onHover(){
        this.animState = 'visible';
    }

    onHoverEnd(){
        this.animState = 'hidden';
    }
}
