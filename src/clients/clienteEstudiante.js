import axios from "axios";

//MÉTODOS
//guardar
const guardar = async (estudianteBody) => {
    const data = axios.post(`http://localhost:8080/API/v1.0/Matricula/estudiantes`, estudianteBody).then(r => r.data);
    console.log(data);
    return data;
}

//actualizar
const actualizarPorCedula = async (cedula, estudianteBody) => {
    const data = axios.put(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${cedula}/actualizarPorCedula`, estudianteBody).then(r => r.data);
    console.log(data);
    return data;
}

//buscar
const buscarPorCedula = async (cedula) => {
    const data = axios.get(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${cedula}/buscarPorCedula`).then(r => r.data)
    return data;
}

//borrar
const eliminarPorCedula = async (cedula) => {
    const data = axios.delete(`http://localhost:8080/API/v1.0/Matricula/estudiantes/${cedula}`).then(r => r.data);
    return data;
}

//MÉTODOS FACHADA
export const guardarFachada = async (estudianteBody) => {
    return await guardar(estudianteBody);
}

export const actualizarPorCedulaFachada = async (cedula, estudianteBody) => {
    return await actualizarPorCedula(cedula, estudianteBody);
}


export const buscarPorCedulaFachada = async (cedula) => {
    return await buscarPorCedula(cedula)

}
//borrar
export const eliminarPorCedulaFachada = async (cedula) => {
    return await eliminarPorCedula(cedula);
}
