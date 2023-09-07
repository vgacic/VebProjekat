//import { createRouter, createWebHashHistory } from 'vue-router'
import { createRouter, createWebHistory } from 'vue-router'

import HomeView from '../views/HomeView.vue'
import HelloWorldVue from '@/components/HelloWorld.vue'
import LoginView from '../views/LoginView.vue'
import PrikazKorisnikaPoIdView from '../views/PrikazKorisnikaPoIdView.vue'
import PrikazSvihKorisnikaView from '../views/PrikazSvihKorisnikaView.vue'
import RegistracijaView from '../views/RegistracijaView.vue'
import PocetnaView from '../views/PocetnaView.vue'
import PrikazPretrazenihKnjigaView from '../views/PrikazPretrazenihKnjigaView'
import PrikazSvihRecenzijaView from '../views/PrikazSvihRecenzijaView'
import PrikazSvihZanrovaView from '../views/PrikazSvihZanrovaView'
import PolicaView from '../views/PolicaView.vue'
import KnjigaView from '../views/KnjigaView.vue'
import PrikazSvihKnjigaView from '../views/PrikazSvihKnjiga.vue'
import ZahteviView from '../views/ZahteviView.vue'
import DodajZanrView from '../views/DodajZanrView.vue'
import DodajRecenzijuView from '../views/DodajRecenzijuView.vue'
import IzmeniRecenzijuView from '../views/IzmeniRecenzijuView.vue'
import DodajKnjiguView from '../views/DodajKnjiguView'
import ZanrView from '../views/ZanrView.vue'
import IzmenaKorisnikaView from '../views/IzmenaKorisnikaView.vue'
import IzmenaNeaktivnogAutoraView from '../views/IzmenaNeaktivnogAutoraView.vue'
import IzmenaKnjigeView from '../views/IzmenaKnjigeView.vue'

const routes = [
  {
    path: '/home',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/AboutView.vue')
  },
  {
    path:'/cao',
    name:'cao',
    component:HelloWorldVue
  },
  {
    path:'/korisnici',
    name:'korisniciView',
    component:PrikazSvihKorisnikaView
  },
  {
    path:'/korisnik/:id',
    name:'prikazKorisnikaPoId',
    component:PrikazKorisnikaPoIdView
  },
  {
    path:'/korisnik',
    name:'prikazKorisnika',
    component:PrikazKorisnikaPoIdView
  },
  {
    path:'/',
    name:'LoginView',
    component:LoginView
  },
  {
    path:'/registracija',
    name:'RegistracijaView',
    component:RegistracijaView
  },
  {
    path:'/pocetna',
    name:'PocetnaView',
    component:PocetnaView
  },
  {
    path:'/pretraga/:query',
    name:'PrikazPretrazenihKnjigaView',
    component:PrikazPretrazenihKnjigaView

  },
  {
    path:'/recenzije',
    name:'RecenzijeView',
    component:PrikazSvihRecenzijaView
  },
  {
    path:'/zanrovi',
    name:'ZanroviView',
    component:PrikazSvihZanrovaView
  
  },
  {
    path:'/polica/:id',
    name:'PolicaView',
    component:PolicaView
  },
  {
    path:'/knjiga/:id',
    name:'KnjigaView',
    component:KnjigaView
  },
  {
    path:'/knjige',
    name:'KnjigeView',
    component:PrikazSvihKnjigaView
  },
  {
    path:'/zahtevi',
    name:'ZahteviView',
    component:ZahteviView
  },
  {
    path:'/dodajZanr',
    name:'DodajZanrView',
    component:DodajZanrView
  },
  {
    path:'/dodajRecenziju/:id',
    name:'DodajRecenzijuView',
    component:DodajRecenzijuView
  },
  {
    path:'/izmeniRecenziju/:id',
    name:'IzmeniRecenzijuView',
    component:IzmeniRecenzijuView
  },
  {
    path:'/dodajKnjigu/:id',
    name:'DodajKnjiguView',
    component:DodajKnjiguView
  },
  {
    path:'/zanr/:id',
    name:'ZanrView',
    component: ZanrView
  },
  {
    path:'/azurirajProfil/:id',
    name:'IzmenaKorisnikaView',
    component:IzmenaKorisnikaView
  },
  {
    path:'/azurirajAutora/:id',
    name:'IzmenaNeaktivnogAutoraView',
    component:IzmenaNeaktivnogAutoraView
  },
  {
    path:'/izmenaKnjige/:id',
    name:'IzmenaKnjigeView',
    component:IzmenaKnjigeView
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
