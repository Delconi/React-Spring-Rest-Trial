import React from 'react';
import ReactDOM from 'react-dom';


export default React.createClass({
	getInitialState: function() {
		return {
			textField: this.props.tfDom
		}
	},
	
	render() {	
		var _that = this;
		
		return <div>
			<label className="col-form-label">{this.state.textField.value}:</label>
			<input className="form-control" type='text' id={this.state.textField.name} onChange={_that.props.onChange}/>
			<br />
		</div>
	}
})