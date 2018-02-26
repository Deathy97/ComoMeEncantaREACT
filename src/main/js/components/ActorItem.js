import React from "react";
import Update from "./Update"
export default class ActorItem extends React.Component {

	constructor(props) {
		super(props)
	}

  render() {

    const { actor } = this.props;
  
    return (
      <div class="well col-md-4 col-md-offset-4" key={actor.dni}>
        dni: {actor.dni} nombre: {actor.nombre} fecha: {actor.fechaNacimiento}<br/>
        <Update id={actor.dni}/>
      </div> 
    );
  }
}
