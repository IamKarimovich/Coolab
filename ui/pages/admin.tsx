import axios from 'axios'

export default function Admin() {
	const sendRequest = () => {
		var data = new FormData()
		data.append(
			'name',
			(document.getElementById('name') as HTMLInputElement).value
		)
		data.append(
			'description',
			(document.getElementById('description') as HTMLInputElement).value
		)
		data.append('image', (document.getElementById('image') as any).files[0])
		data.append(
			'date',
			(document.getElementById('date') as HTMLInputElement).value
		)
		data.append(
			'link',
			(document.getElementById('link') as HTMLInputElement).value
		)
		data.append(
			'eventType',
			(document.getElementById('eventType') as HTMLInputElement).value
		)
		data.append(
			'status',
			(document.getElementById('status') as HTMLInputElement).value
		)
		axios({
			method: 'post',
			url: '/api/events/',
			data: data,
			headers: { 'Content-Type': 'multipart/form-data' },
		}).then((d) => {
			console.log(d)
		})
	}

	return (
		<div className="admin-container">
			<div className="create-event">
				<div>
					<label htmlFor="">Name</label>
					<input placeholder="Name..." type="text" name="name" id="name" />
				</div>
				<div>
					<label htmlFor="">Description</label>
					<input placeholder="Description..." type="text" name="description" id="description" />
				</div>
				<div>
					<label htmlFor="">Date</label>
					<input placeholder="Date..." type="text" name="date" id="date" />
				</div>
				<div>
					<label htmlFor="">Link</label>
					<input placeholder="Link..." type="text" name="link" id="link" />
				</div>
				<div>
					<label htmlFor="">Event type</label>
					<input placeholder="Event type..." type="text" name="eventType" id="eventType" />
				</div>
				<div>
					<label htmlFor="">Status</label>
					<input placeholder="Status..." type="text" name="status" id="status" />
				</div>
				<div>
					<label htmlFor="">Image</label>
					<input type="file" name="image" id="image" />
				</div>
				<button
					onClick={() => {
						sendRequest()
					}}
				>
					Create
				</button>
			</div>
		</div>
	)
}
