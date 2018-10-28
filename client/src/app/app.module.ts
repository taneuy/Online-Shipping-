import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router';
import { CommonModule} from '@angular/common';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BikeOrderComponent } from './bike-order/bike-order.component';
import { BikeShowComponent } from './bike-show/bike-show.component';
import { ConvenienceOrderComponent } from './convenience-order/convenience-order.component';
import { ConvenienceShowComponent } from './convenience-show/convenience-show.component';
import { FoodOrderComponent } from './food-order/food-order.component';
import { FoodShowComponent } from './food-show/food-show.component';
import { MessengerOrderComponent } from './messenger-order/messenger-order.component';
import { MessengerShowComponent } from './messenger-show/messenger-show.component';
import { PostalOrderComponent } from './postal-order/postal-order.component';
import { PostalShowComponent } from './postal-show/postal-show.component';
import { TaxiOrderComponent } from './taxi-order/taxi-order.component';
import { TaxiShowComponent } from './taxi-show/taxi-show.component';

import { BikeService } from './service/bike.service';
import { ConvenienceService } from './service/convenience.service';
import { FoodService } from './service/food.service';
import { MessengerService } from './service/messenger.service';
import { PostalService } from './service/postal.service';
import { TaxiService } from './service/taxi.service';

import { MessengerViewComponent } from './messenger-view/messenger-view.component';
import { ConvenienceCreateComponent } from './convenience-create/convenience-create.component';
import { ConvenienceManageComponent } from './convenience-manage/convenience-manage.component';
import { ConvenienceViewComponent } from './convenience-view/convenience-view.component';




import {
  MatAutocompleteModule,
  MatBadgeModule,
  MatBottomSheetModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatDividerModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSidenavModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatStepperModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatTreeModule,
} from '@angular/material';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BikeViewComponent } from './bike-view/bike-view.component';
import { TaxiViewComponent } from './taxi-view/taxi-view.component';
import { FoodManageComponent } from './food-manage/food-manage.component';
import { FoodCreateComponent } from './food-create/food-create.component';
import { FoodViewComponent } from './food-view/food-view.component';


const routes: Routes = [
  {path: '', redirectTo:'/login', pathMatch: 'full' },
  {path: 'home', component: HomeComponent},
  {path: 'food', component: FoodOrderComponent},
  {path: 'convenience', component: ConvenienceOrderComponent},
  {path: 'taxi', component: TaxiOrderComponent},
  {path: 'bike', component: BikeOrderComponent},
  {path: 'postal', component: PostalOrderComponent},
  {path: 'messenger', component: MessengerOrderComponent},
  {path: 'food-show', component: FoodShowComponent},
  {path: 'convenience-show', component: ConvenienceShowComponent},
  {path: 'taxi-show', component: TaxiShowComponent},
  {path: 'bike-show', component: BikeShowComponent},
  {path: 'postal-show', component: PostalShowComponent},
  {path: 'messenger-show', component: MessengerShowComponent},
  {path: 'messenger-view', component: MessengerViewComponent},
  {path: 'bike-view', component: BikeViewComponent},
  {path: 'taxi-view', component: TaxiViewComponent},
  {path: 'convenience-create', component: ConvenienceCreateComponent},
  {path: 'convenience-manage/:id', component: ConvenienceManageComponent},
  {path: 'convenience-view/:id', component: ConvenienceViewComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'bike-view', component: RegisterComponent},
  {path: 'taxi-view', component: RegisterComponent},
  {path: 'food-create', component: FoodCreateComponent},
  {path: 'food-manage/:id', component: FoodManageComponent},
  {path: 'food-view/:id', component: FoodViewComponent},
  
];

@NgModule({
  declarations: [
    AppComponent,
    FoodOrderComponent,
    ConvenienceOrderComponent,
    TaxiOrderComponent,
    BikeOrderComponent,
    PostalOrderComponent,
    MessengerOrderComponent,
    HomeComponent,
    BikeShowComponent,
    ConvenienceShowComponent,
    FoodShowComponent,
    MessengerShowComponent,
    PostalShowComponent,
    TaxiShowComponent,
    MessengerViewComponent,
    ConvenienceCreateComponent,
    ConvenienceManageComponent,
    ConvenienceViewComponent,
    LoginComponent,
    RegisterComponent,
    BikeViewComponent,
    TaxiViewComponent,
    FoodManageComponent,
    FoodCreateComponent,
    FoodViewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    MatAutocompleteModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatDatepickerModule,
    MatDialogModule,
    MatDividerModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatStepperModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    MatTreeModule,
    RouterModule.forRoot(routes),
  ],
  providers: [BikeService, ConvenienceService, FoodService, MessengerService, PostalService, TaxiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
