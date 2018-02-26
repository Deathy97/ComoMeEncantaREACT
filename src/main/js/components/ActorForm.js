import React from "react";
import { addActor } from "../actions/actorActions"

export default class ActorForm extends React.Component {

  constructor() {
    super();
    this.state = {
    		
      dni: "",
      nombre: "",
      fechaNacimiento: ""
    
    }
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  keyPressed(event) {
    if (event.keyCode == 13) { // If enter is pressed
    	this.addActor();
      console.log("item inserted")
    }
  }

  addActor() { //que no panda el cunico que paco llama a actores
	  addActor(this.state);
  }

  render() {
    const cssStyle = {
      'marginBottom': '20px'
    }

    return (
      <div class="input-group col-md-4 col-md-offset-4" style={cssStyle}>
        <div>
          <input type="text" class="form-control"
            name="dni"
            placeholder="Add a new actor dni..."
            value={this.state.dni}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="text" class="form-control"
            name="nombre"
            placeholder="Add a new actor name..."
            value={this.state.nombre}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
          <input type="date" class="form-control"
            placeholder="Add a new actor document fecha..."
            name="fechaNacimiento"
            value={this.state.fechaNacimiento}
            onChange={this.handleChange.bind(this)}
            onKeyDown={this.keyPressed.bind(this)} />
        </div>
        <div>
          <button className="btn btn-default" type="button" onClick={this.addActor.bind(this)}>Insert Actor</button>
        </div>
      </div>
    );
  }
}