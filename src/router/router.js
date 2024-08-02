//parecido a las funcionalidades fachada
//importo funcionalidades de la libreria router
import { createRouter, createWebHashHistory } from "vue-router"

//importamos las paginas
import ConsultarActualizarEstudiantePage from "@/Pages/ConsultarActualizarEstudiantePage.vue"
import EliminarEstudiantePage from "@/Pages/EliminarEstudiantePage.vue"
import InsertarEstudiantePage from "@/Pages/InsertarEstudiantePage.vue"
import BienvenidaPage from "@/Pages/BienvenidaPage.vue"

const routes = [

    {
        path: "/ingresar",
        component: InsertarEstudiantePage
    },
    {
        path: "/eliminar",
        component: EliminarEstudiantePage
    },
    {
        path: "/consultarActualizar",
        component: ConsultarActualizarEstudiantePage
    },
    {
        path: "/",
        component: BienvenidaPage
    }
]

//constante y utilizo los componentes que importe del router
const router = createRouter({
    history: createWebHashHistory(), routes
})

//finalizar
export default router